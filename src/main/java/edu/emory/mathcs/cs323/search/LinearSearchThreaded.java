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
package edu.emory.mathcs.cs323.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class LinearSearchThreaded<T extends Comparable<T>> implements ISearch<T>
{
	private int thread_size;
	
	public LinearSearchThreaded(int threadSize)
	{
		thread_size = threadSize;	
	}
	
	@Override
	public int search(List<T> list, T key)
	{
		ExecutorService pool = Executors.newFixedThreadPool(thread_size);
		List<Future<Integer>> maxList = new ArrayList<>();
		final int gap = list.size() / thread_size;
		int beginIndex, endIndex;
		Callable<Integer> task;
		
		for (int i=0; i<thread_size; i++)
		{
			beginIndex = i * gap;
			endIndex = (i+1 == thread_size) ? list.size() : (i+1) * gap;
			task = new SearchTask(list, key, beginIndex, endIndex);
			maxList.add(pool.submit(task));
		}

		pool.shutdown();
		int index;
		
		try
		{
			for (int i=0; i<thread_size; i++)
			{
				index = maxList.get(i).get();
				if (index >= 0) return index;
			}
		}
		catch (Exception e) {e.printStackTrace();}
		
		return -1;
	}
	
	class SearchTask implements Callable<Integer>
	{
		int     begin_index;
		int     end_index;
		List<T> t_list;
		T       t_key;
		
		/**
		 * @param beginIndex the beginning index to search from (inclusive).
		 * @param endIndex the ending index to search to (exclusive).
		 */
		public SearchTask(List<T> list, T key, int beginIndex, int endIndex)
		{
			begin_index = beginIndex;
			end_index   = endIndex;
			t_list      = list;
			t_key       = key;
		}

		@Override
		public Integer call() throws Exception
		{
			for (int i=begin_index; i<end_index; i++)
			{
				if (t_key.equals(t_list.get(i)))
					return i;
			}
			
			return -1;
		}
    }
}
