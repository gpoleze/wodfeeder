UPDATE workout_of_the_day
    SET week = extract('week' from date)
    WHERE week = 0;