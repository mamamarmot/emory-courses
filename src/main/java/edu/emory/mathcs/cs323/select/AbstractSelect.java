/**
 * Copyright 2014, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.cs323.select;


/** @author Jinho D. Choi ({@code jinho.choi@emory.edu}) */
abstract public class AbstractSelect<T extends Comparable<T>>
{
	/**
	 * @return the item with the k'th maximum value in the array.
	 * @throws IllegalArgumentException if {@code array} is {@code null} or {@code array.length < k}. 
	 */
	public T max(T[] array, int k)
	{
		if (array == null || array.length < k)
			throw new IllegalArgumentException();
		
		return maxAux(array, k);
	}
	
	/** An auxiliary method of {@link #max(Comparable[], int)}. */
	abstract protected T maxAux(T[] array, int k);
}
