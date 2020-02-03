package org.gnius.hr.repository.model.common;

/**  <p>
 * REpresent a simple search by example Holder.<br>
 * With page information and, in future order information also.
 * </p>
 * TODO Add Order information.
 * TODO Add more elements (not, like)
 * @author gianluca
 *
 * @param <T>
 */
public class Search<T extends BasePanacheEntity> {
	public T eq;
	public T like;
	public T ge;
	public T le;
	
	public String order;
	
	public Page page;
}
