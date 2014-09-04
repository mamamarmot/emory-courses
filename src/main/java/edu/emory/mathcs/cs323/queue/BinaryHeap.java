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
package edu.emory.mathcs.cs323.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class BinaryHeap<T extends Comparable<T>> extends AbstractPriorityQueue<T>
{
	private List<T> l_keys;
	private int n_size;
	
	public BinaryHeap()
	{
		l_keys = new ArrayList<>();
		l_keys.add(null);
		n_size = 0;
	}

	@Override
	public int size()
	{
		return n_size;
	}

	@Override
	public void add(T key)
	{
		l_keys.add(key);
		swim(++n_size);
	}

	@Override
	public T removeMax()
	{
		T max = l_keys.get(1);
		swap(1, n_size);
		l_keys.remove(n_size--);
		sink(1);
		return max;
	}
	
	private void swim(int k)
	{
		while (k > 1 && compareTo(k/2, k) < 0)
		{
			swap(k/2, k);
			k /= 2;
		}
	}
	
	private void sink(int k)
	{
		for (int i=2*k; i<=n_size; k=i,i=2*k)
		{
			if (i < n_size && compareTo(i, i+1) < 0) i++;
			if (compareTo(k, i) >= 0) break;
			swap(k, i);
		}
	}
	
	private int compareTo(int i, int j)
	{
		return l_keys.get(i).compareTo(l_keys.get(j));
	}
	
	private void swap(int i, int j)
	{
		l_keys.set(j, l_keys.set(i, l_keys.get(j)));
	}
}
