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
package edu.emory.mathcs.cs323.sort;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractSort<T extends Comparable<T>>
{
	protected long n_comparisons;
	protected long n_assignments;
	
	public AbstractSort()
	{
		resetCounts();
	}
	
	/**
	 * Sorts the array in ascending order.
	 * @param array an array of comparable keys.
	 */
	abstract public void sort(T[] array);
	
	public void resetCounts()
	{
		n_comparisons = 0;
		n_assignments = 0;
	}
	
	public long getComparisonCount()
	{
		return n_comparisons;
	}
	
	public long getAssignmentCount()
	{
		return n_assignments;
	}
	
	protected int compareTo(T[] array, int i, int j)
	{
		n_comparisons++;
		return array[i].compareTo(array[j]);
	}
	
	protected void assign(T[] array, int index, T value)
	{
		n_assignments++;
		array[index] = value;
	}
	
	protected void swap(T[] array, int i, int j)
	{
		T t = array[i];
		assign(array, i, array[j]);
		assign(array, j, t);
	}
}
