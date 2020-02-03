package org.gnius.hr.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.tools.JavaFileObject;

import com.google.auto.service.AutoService;

/**
 * REF:<br>
 * https://www.baeldung.com/java-annotation-processing-builder<br>
 * https://github.com/eugenp/tutorials/blob/master/annotations/annotation-processing/src/main/java/com/baeldung/annotation/processor/BuilderProcessor.java<br>
 * <br>
 * 
 * @author gianluca
 *
 */
@SupportedAnnotationTypes("org.gnius.hr.tools.UpdatableEntity")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class UpdatableEntityProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		for (TypeElement annotation : annotations) {
			Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

			Map<Boolean, List<Element>> annotatedClass = annotatedElements.stream()
					.collect(Collectors.partitioningBy(element -> (element.asType().getKind()) == TypeKind.DECLARED));

			List<Element> good = annotatedClass.get(true);
			// TODO controlla se ci sono elementi bad, e segnala errore.

			// Per ogni elemento annotato devo ottenere la lista dei field pubblici.
			good.stream().forEach(typeElement -> {
				Set<String> fields = typeElement.getEnclosedElements().stream()
						.filter(o -> (o.getKind().isField() && ElementUtil.isPublic(o)))
						.map(o -> ElementUtil.getName(o)).collect(Collectors.toSet());
				try {
					writeHelperFile(ElementUtil.getName(typeElement), fields);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			// Poi devo generare una classe che, date due istanze dell'elemento, copia tutti
			// i valori (salvo uuid ?)
			// Dal primo al secondo

		}
		return false;
	}

	private void writeHelperFile(String className, Set<String> fieldMap) throws IOException {

		String packageName = null;
		int lastDot = className.lastIndexOf('.');
		if (lastDot > 0) {
			packageName = className.substring(0, lastDot);
		}

		String simpleClassName = className.substring(lastDot + 1);
		String builderClassName = className + "Updater";
		String builderSimpleClassName = builderClassName.substring(lastDot + 1);

		JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(builderClassName);

		try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

			if (packageName != null) {
				out.print("package ");
				out.print(packageName);
				out.println(";");
				out.println();
			}

			out.print("public class ");
			out.print(builderSimpleClassName);
			out.println(" {");
			out.println();

			out.print("    public update(");
			out.print(simpleClassName);
			out.print(" provided, ");
			out.print(simpleClassName);
			out.println(" target) {");

			fieldMap.stream().forEach(field -> {
				out.print("    target.");
				out.print(field);
				out.print(" = provided.");
				out.print(field);
				out.println(";");
			});
			out.println("    }");
			out.println();

			out.println("}");
		}
	}
}
