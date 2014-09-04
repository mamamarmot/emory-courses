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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SortTest
{
	@Test
	public void testAccuracy()
	{
		testAccuracy(new InsertionSort<>());
		testAccuracy(new MergeSort<>());
	}
	
	void testAccuracy(ISort<Integer> s)
	{
		Integer[] originalArray = {5, 2, 3, 2, 1, 1, 4, 2};
		Integer[] sortedArray;
		
		sortedArray = Arrays.copyOf(originalArray, originalArray.length);
		Arrays.sort(sortedArray);
		s.sort(originalArray);
		
		for (int i=0; i<originalArray.length; i++)
			assertEquals(sortedArray[i], originalArray[i]);
	}
}
