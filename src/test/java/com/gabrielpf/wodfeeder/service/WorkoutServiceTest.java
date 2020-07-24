package com.gabrielpf.wodfeeder.service;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.gabrielpf.wodfeeder.model.Workout;
import com.gabrielpf.wodfeeder.model.WorkoutTypeEnum;
import com.gabrielpf.wodfeeder.repo.WorkoutRepo;
import com.gabrielpf.wodfeeder.vo.WorkoutVO;

@SpringJUnitConfig
class WorkoutServiceTest {

    @MockBean
    private WorkoutRepo mockRepository;
    private WorkoutService service;
    private static final List<Workout> expectedWorkouts = new ArrayList<>();

    @BeforeAll
    static void init() {
        expectedWorkouts.add(new Workout()
                .setId(UUID.randomUUID())
                .setDate(LocalDate.now())
                .setType(WorkoutTypeEnum.WARM_UP.getType())
                .setExercise("Exercise 1")
                .setPosition(1));
        expectedWorkouts.add(new Workout()
                .setId(UUID.randomUUID())
                .setDate(LocalDate.now().plusDays(1))
                .setType(WorkoutTypeEnum.DEVELOPMENT.getType())
                .setExercise("Exercise 2")
                .setPosition(2));
        expectedWorkouts.add(new Workout()
                .setId(UUID.randomUUID())
                .setDate(LocalDate.now().plusDays(2))
                .setType(WorkoutTypeEnum.DEVELOPMENT.getType())
                .setExercise("Exercise 3")
                .setPosition(3));
    }

    @BeforeEach
    void setUp() {
        service = new WorkoutService(mockRepository);
    }

    @Test
    void checkAllResultsAreReturned() {
        when(mockRepository.findAll(Pageable.unpaged())).thenReturn(new PageImpl(expectedWorkouts));

        final var actual = service.findAll(Pageable.unpaged());
        assertEquals(
                "Size expected was " + expectedWorkouts.size() + " while actual was " + actual.size(),
                expectedWorkouts.size(),
                actual.size()
        );
        expectedWorkouts.parallelStream().forEach(expected -> {
            final var workoutVO = actual.stream().filter(vo -> vo.getPosition() == expected.getPosition()).findFirst().orElseThrow(NoSuchElementException::new);
            assertTrue("Dates are not the same", expected.getDate().equals(workoutVO.getDate()));
            assertTrue("Types are not the same", expected.getType().equals(workoutVO.getType()));
            assertTrue("Exercise are not the same", expected.getExercise().equals(workoutVO.getExercise()));
        });
    }

    @Test
    void verifyThatWhenSearchingByDateOnlyContainsTheRequiredDate() {
        final var now = LocalDate.now();
        final List<Workout> expected = expectedWorkouts
                .stream()
                .filter(workout -> workout.getDate().equals(now))
                .collect(Collectors.toUnmodifiableList());

        when(mockRepository.findByDate(now)).thenReturn(Optional.of(expected));

        final var actual = service.findByDate(now);
        assertEquals("Workouts are not the same", new WorkoutVO(expected.get(0)), actual.get(0));
    }

    @Test
    void verifyThatWhenSearchingByDateWithoutAWorkoutTheListIsEmpty() {
        final var date = LocalDate.now().plusYears(1000);
        when(mockRepository.findByDate(date)).thenReturn(Optional.empty());

        final var actual = service.findByDate(date);
        assertTrue("List is not empty", actual.isEmpty());
    }
}