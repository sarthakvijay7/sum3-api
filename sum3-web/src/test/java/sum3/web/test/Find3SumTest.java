package sum3.web.test;

import static org.junit.Assert.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import sum3.web.app.Sum3ApiApplication;

@SpringBootTest(classes = Sum3ApiApplication.class)
public class Find3SumTest {

	@Test
	public void test3Sum() {
		List<Long> numberList = new ArrayList<>(Arrays.asList(3l, 4l, 9l, 2l));
		Long targetNumber = 16l;

		Boolean numbersFound = false;
		for (int i = 0; i < numberList.size() - 2; i++) {

			HashSet<Long> s = new HashSet<>();
			Long present_sum = targetNumber - numberList.get(i);
			for (int j = i + 1; j < numberList.size(); j++) {
				if (s.contains(present_sum - numberList.get(j))) {
					numbersFound = true;
					break;
				}
				s.add(numberList.get(j));
			}
		}
		assertTrue(numbersFound);
	}
}
