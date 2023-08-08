package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

/**
 * • 요구사항
 * • 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * • 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    /**
     * 1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
     * -> 학점계산기 도메인 : 이수한 과목, 학점 계산기
     * 2. 객체들 간의 관계를 고민
     * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
     * -> 동적인 객체 : 이수한과목 : 객체지향프로그래밍,자료구조 ... => 정적인 타입(클래스) : 과목(코스)
     * 4. 협력을 설계
     * -> 이수한 과목을 전달하여 평균 학점 계산 요청 -----> 학점계산기 -----> (학점수 * 교과목 평점 ) 의 합계 ---> 과목(코스)
     *                                                        ------> 수강신청 총학점 수            ---> 과목(코스)
     * 5. 객체들을 포괄하는 타입에 적절한 책임을 할당
     * 6. 구현하기
     */

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest(){
        List<Course> courses = List.of(new Course("OOP",3,"A+"),
                new Course("자료구조",3,"A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);

    }
}
