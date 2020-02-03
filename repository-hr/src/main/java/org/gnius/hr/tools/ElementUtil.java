package org.gnius.hr.tools;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/**
 * Hints from
 * https://github.com/google/j2objc/blob/master/translator/src/main/java/com/google/devtools/j2objc/util/ElementUtil.java
 * 
 * @author gianluca
 *
 */
public class ElementUtil {

	public static String getName(Element element) {
		// Always return qualified package names.
		Name name = element.getKind() == ElementKind.PACKAGE ? ((PackageElement) element).getQualifiedName()
				: element.getSimpleName();
		return name.toString();
	}

	public static String getQualifiedName(TypeElement element) {
		return element.getQualifiedName().toString();
	}

	public static boolean isTypeParameterElement(Element e) {
		return e.getKind() == ElementKind.TYPE_PARAMETER;
	}

	public static boolean isPublic(Element element) {
		return hasModifier(element, Modifier.PUBLIC);
	}

	private static boolean hasModifier(Element element, Modifier modifier) {
		return element.getModifiers().contains(modifier);
	}
}
