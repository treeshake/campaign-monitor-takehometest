import { findMostCommon } from "./question-4-most-common";

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
