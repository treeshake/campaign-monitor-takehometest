import {
  findMostCommon
} from "./question-4-most-common";

describe("findMostCommon", () => {
  test("should return the most common number in the array", () => {
    const firstSampleResults = findMostCommon([
      5, 4, 3, 2, 4, 5, 1, 6, 1, 2, 5, 4,
    ]);
    const secondSampleResults = findMostCommon([1, 2, 3, 4, 5, 1, 6, 7]);
    const thirdSampleResults = findMostCommon([1, 2, 3, 4, 5, 6, 7]);

    expect(firstSampleResults.length).toEqual(2);
    expect(firstSampleResults).toEqual(expect.arrayContaining([4, 5]));

    expect(secondSampleResults.length).toEqual(1);
    expect(secondSampleResults).toEqual(expect.arrayContaining([1]));

    expect(thirdSampleResults.length).toEqual(7);
    expect(thirdSampleResults).toEqual(
      expect.arrayContaining([1, 2, 3, 4, 5, 6, 7])
    );
  });

  test("should return an empty array for empty input", () => {
    expect(findMostCommon([])).toEqual([]);
  });

  test("should throw InvalidInputException for non-array input", () => {
    expect(() => findMostCommon(null)).toThrow("Supplied input 'null' is invalid: Expected an array");
  });

  test("should throw InvalidInputException for array with non-number elements", () => {
    expect(() => findMostCommon([1, "a", 3])).toThrow(
      "Supplied input '[1,\"a\",3]' is invalid: One or more values is not a number"
    );
  });
});
