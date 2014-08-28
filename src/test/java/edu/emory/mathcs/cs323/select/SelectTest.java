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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class SelectTest 
{
	@Test
	public void testAccuracy()
	{
		AbstractSelect<Integer> s1 = new Select1<Integer>();
		AbstractSelect<Integer> s2 = new Select2<Integer>();
		AbstractSelect<Integer> s3 = new Select3<Integer>();
		
		Integer[] originalArray = {4,1,3,2,5,6,8,3,4,7,5,9,7};
		Integer[] sortedArray   = Arrays.copyOf(originalArray, originalArray.length);
		Arrays.sort(sortedArray, Collections.reverseOrder());
		
		for (int k=0; k<originalArray.length; k++)
		{
			assertEquals(sortedArray[k], s1.max(originalArray, k+1));
			assertEquals(sortedArray[k], s2.max(originalArray, k+1));
			assertEquals(sortedArray[k], s3.max(originalArray, k+1));
		}
	}
	
	@Test
	public void testSpeed()
	{
		AbstractSelect<Integer> s1 = new Select1<Integer>();
		AbstractSelect<Integer> s2 = new Select2<Integer>();
		AbstractSelect<Integer> s3 = new Select3<Integer>();
		Integer[] array = getRandomArray(1000, 0);
		int warmup = 10, benchmark = 1000;
		
		for (int k=1; k<=100; k++)
		{
//			System.out.printf("%2d:"  , k);
//			System.out.printf("%10d"  , testSelect(s1, array, k, warmup, benchmark));
//			System.out.printf("%10d"  , testSelect(s2, array, k, warmup, benchmark));
//			System.out.printf("%10d\n", testSelect(s3, array, k, warmup, benchmark));
			
			System.out.print(testSelect(s1, array, k, warmup, benchmark)+"\t");
			System.out.print(testSelect(s2, array, k, warmup, benchmark)+"\t");
			System.out.print(testSelect(s3, array, k, warmup, benchmark)+"\n");
		}
	}
	
	private Integer[] getRandomArray(int size, int seed)
	{
		Integer[] array = new Integer[size];
		Random rand = new Random(seed);
		
		for (int i=0; i<size; i++)
			array[i] = rand.nextInt();
		
		return array;
	}
	
	private long testSelect(AbstractSelect<Integer> s, Integer[] array, int k, int warmup, int benchmark)
	{
		long st, et;
		int i;
		
		for (i=0; i<warmup; i++) s.max(array, k);
		st = System.currentTimeMillis();
		for (i=0; i<benchmark; i++) s.max(array, k);
		et = System.currentTimeMillis();
		
		return et - st;
	}
}
