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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SearchTest
{
	@Test
	public void testAccuracy()
	{
		List<Integer> randomList = getRandomList(new Random(0), 10, 10);
		List<Integer> sortedList = new ArrayList<>(randomList);
		Collections.sort(sortedList);
		
		ISearch<Integer> s1 = new SequentialSearch<>();
		ISearch<Integer> s2 = new BinarySearch<>();
		int actual;
		
		for (Integer key : randomList)
		{
			actual = Collections.binarySearch(sortedList, key);
			assertEquals(s1.search(sortedList, key), actual);
			assertEquals(s2.search(sortedList, key), actual);
		}
		
		for (int key : new int[]{-1, 20})
		{
			assertTrue(s1.search(sortedList, key) < 0);
			assertTrue(s2.search(sortedList, key) < 0);
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void testSpeed()
	{
		testSpeed(new SequentialSearch<Integer>(), new BinarySearch<Integer>());
	}
	
	@SuppressWarnings("unchecked")
	public void testSpeed(ISearch<Integer>... engines)
	{
		final int inc = 100, warmup = 10, benchmark = 1000;;
		final Random rand = new Random(0);
		
		List<Integer> randomList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		StringBuilder build = new StringBuilder();
		List<Integer> list;
		
		for (int i=1; i<=10; i++)
		{
			list = getRandomList(rand, i*inc, Integer.MAX_VALUE);
			randomList.addAll(list);
			sortedList.addAll(list);
			Collections.sort(sortedList);
			
			for (ISearch<Integer> engine : engines)
			{
				getRunTime(randomList, sortedList, engine, warmup);
				build.append(getRunTime(randomList, sortedList, engine, benchmark));
				build.append("\t");
			}
			
			build.append("\n");
		}
		
		System.out.println(build.toString());
	}
	
	List<Integer> getRandomList(Random rand, int size, int bound)
	{
		List<Integer> list = new ArrayList<>(size);
		
		for (int i=0; i<size; i++)
			list.add(rand.nextInt(bound));
		
		return list;
	}
	
	long getRunTime(List<Integer> randomList, List<Integer> sortedList, ISearch<Integer> engine, int iterations)
	{
		long st, et;
		int i;
		
		st = System.currentTimeMillis();
		
		for (i=0; i<iterations; i++)
		{
			for (Integer item : randomList)
				engine.search(sortedList, item);			
		}
		
		et = System.currentTimeMillis();
		
		return et - st;
	}
}
