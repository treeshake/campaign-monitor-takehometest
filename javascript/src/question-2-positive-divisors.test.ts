import { findPositiveDivisors } from "./question-2-positive-divisors";

test("should return 60 for input {1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60}", () => {
  expect(findPositiveDivisors(60)).toEqual([
    1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60,
  ]);
});
