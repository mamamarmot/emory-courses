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
package edu.emory.mathcs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** @author Jinho D. Choi ({@code jinho.choi@emory.edu}) */
public class DSUtils
{
	static public List<Integer> toIntegerList(int... array)
	{
		List<Integer> list = new ArrayList<>(array.length);
		for (int item : array) list.add(item);
		return list;
	}
	
	static public <T>List<T> toList(T[] array)
	{
		List<T> list = new ArrayList<>(array.length);
		for (T item : array) list.add(item); 
		return list;
	}
	
	static public List<Integer> getRandomIntegerList(Random rand, int size)
	{
		List<Integer> list = new ArrayList<>(size);
		
		for (int i=0; i<size; i++)
			list.add(rand.nextInt());
		
		return list;
	}
	
	static public int[] getRandomIntArray(Random rand, int size)
	{
		int[] array = new int[size];
		
		for (int i=0; i<size; i++)
			array[i] = rand.nextInt();
		
		return array;
	}
	
	static public <T extends Comparable<T>>int compareTo(List<T> list, int i, int j)
	{
		return list.get(i).compareTo(list.get(j));
	}
	
	static public <T extends Comparable<T>>int compareTo(T[] array, int i, int j)
	{
		return array[i].compareTo(array[j]);
	}
	
	static public <T extends Comparable<T>>void swap(List<T> list, int i, int j)
	{
		list.set(j, list.set(i, list.get(j)));
	}
	
	static public <T extends Comparable<T>>void swap(T[] array, int i, int j)
	{
		T t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
