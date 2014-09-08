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

import edu.emory.mathcs.cs323.queue.BinaryHeap;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class HeapSort<T extends Comparable<T>> extends AbstractSort<T>
{
	BinaryHeap<T> b_heap;
	
	public HeapSort()
	{
		super();
		b_heap = new BinaryHeap<>();
	}
	
	@Override
	public void sort(T[] array)
	{
		int endIndex = array.length - 1;
		
		for (int k=getParentIndex(endIndex); k>=0; k--)
			sink(array, k, endIndex);
		
		while (endIndex > 0)
		{
			swap(array, 0, endIndex--);
			sink(array, 0, endIndex);
		}
	}
	
	private void sink(T[] array, int k, int endIndex)
	{
		for (int i=getLeftChildIndex(k); i<=endIndex; k=i,i=getLeftChildIndex(k))
		{
			if (i < endIndex && compareTo(array, i, i+1) < 0) i++;
			if (compareTo(array, k, i) >= 0) break;
			swap(array, k, i);
		}
	}
	
	private int getParentIndex(int k)
	{
		return (k+1)/2 - 1; 
	}
	
	private int getLeftChildIndex(int k)
	{
		return 2*k + 1;
	}
}
