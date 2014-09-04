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

import java.util.Arrays;

import edu.emory.mathcs.utils.DSUtils;
import edu.emory.mathcs.utils.MathUtils;


/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class MergeSort<T extends Comparable<T>> implements ISort<T>
{
	@Override
	public void sort(T[] array)
	{
		sort(array, null, 0, array.length-1);
	}
	
	/**
	 * @param beginIndex the beginning index of the 1st half (inclusive).
	 * @param middleIndex the ending index of the 1st half (inclusive).
	 * @param endIndex the ending index of the 2nd half (inclusive).
	 */
	private void sort(T[] array, T[] temp, int beginIndex, int endIndex)
	{
		if (beginIndex >= endIndex) return;
		int middleIndex = MathUtils.getMiddleIndex(beginIndex, endIndex);
		sort(array, temp, beginIndex, middleIndex);
		sort(array, temp, middleIndex+1, endIndex);
		merge(array, temp, beginIndex, middleIndex, endIndex);
	}
	
	/**
	 * @param beginIndex the beginning index of the 1st half (inclusive).
	 * @param middleIndex the ending index of the 1st half (inclusive).
	 * @param endIndex the ending index of the 2nd half (inclusive).
	 */
	private void merge(T[] array, T[] temp, int beginIndex, int middleIndex, int endIndex)
	{
		int fst = beginIndex, snd = middleIndex + 1;
		temp = copyArray(array, temp);
		
		for (int k=beginIndex; k<=endIndex; k++)
		{
			if (fst > middleIndex)		// all keys in the 1st half are visited   
				array[k] = temp[snd++];
			else if (snd > endIndex)	// all keys in the 2nd half are visited
				array[k] = temp[fst++];
			else if (DSUtils.compareTo(temp, fst, snd) < 0)	// 1st key < 2nd key
				array[k] = temp[fst++];
			else
				array[k] = temp[snd++];
		}
	}
	
	private T[] copyArray(T[] array, T[] temp)
	{
		if (temp == null)
			return Arrays.copyOf(array, array.length);
		else
		{
			System.arraycopy(array, 0, temp, 0, array.length);
			return temp;
		}
	}
}
