import { findPositiveDivisors } from "./question-2-positive-divisors";

describe("findPositiveDivisors", () => {
  test("should return 60 for input {1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60}", () => {
    expect(findPositiveDivisors(60)).toEqual([
      1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60,
    ]);
  });

  test("should throw an error for non-number input", () => {
    expect(() => findPositiveDivisors("a")).toThrow(
      "Invalid input: Expected positive number, but got 'a'"
    );
  });

  test("should throw an error for null/undefined input", () => {
    expect(() => findPositiveDivisors(null)).toThrow(
      "Invalid input: Expected positive number, but got 'null'"
    );
    expect(() => findPositiveDivisors(undefined)).toThrow(
      "Invalid input: Expected positive number, but got 'undefined'"
    );
  });

  test("should throw an error for negative number input", () => {
    expect(() => findPositiveDivisors(-5)).toThrow(
      "Invalid input: Expected positive number, but got '-5'"
    );
  });
});
