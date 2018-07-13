package com.jp.wonfes.service.sample;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SampleLogic1_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	SampleDto sampleDtoTest;
	@Before
	public void setUp() throws Exception {
		sampleDtoTest = new SampleDto();
		sampleDtoTest.setId("123");
		sampleDtoTest.setAge(21);
		sampleDtoTest.setName("ろっく");
		System.out.println("a");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		
		SampleLogic1 testClass1 = new SampleLogic1();
		String cd1 = "iwatakhr";
		testClass1.dosomething(cd1);
		
		assertEquals(cd1+"といっしょだよ",cd1,testClass1.get_hensu1());
//		fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		
		SampleLogic1 testClass1 = new SampleLogic1();
		String cd1 = "not iwatakhr";
		testClass1.setDto(sampleDtoTest);
		
		
		testClass1.dosomething(cd1);
		
		assertNotNull(testClass1.get_hensu1());
		
	}
	
	// DummyTest
	@Ignore("ignore3")
	@Test
	public void test3() {
		
		SampleLogic1 testClass1 = new SampleLogic1();
		String cd1 = "iwatakhr";
		testClass1.dosomething(cd1);
		
		assertEquals(cd1+"といっしょだよ",cd1,testClass1.get_hensu1());
		assertNotNull(testClass1.get_hensu1());
		
	}
	
	// DummyTest
	@Ignore("ignore4")
	@Test
	public void test4() {
		
		SampleLogic1 testClass1 = new SampleLogic1();
		String cd1 = "iwatakhr";
		testClass1.dosomething(cd1);
		
		assertEquals(cd1+"といっしょだよ",cd1,testClass1.get_hensu1());
		assertNotNull(testClass1.get_hensu1());
		
	}
	

}
