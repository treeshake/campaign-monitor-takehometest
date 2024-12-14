import { areaOfTriangle } from "./question-3-area-triangle";

describe("areaOfTriangle", () => {
  test("should calculate the area of a triangle correctly", () => {
    expect(areaOfTriangle([3, 4, 5])).toBe(6);
  });

  test("should throw an error for non-number input", () => {
    expect(() => areaOfTriangle([NaN, 4, 5])).toThrow(
      "Supplied inputs '[null,4,5]' is invalid: One or more sides is not a number"
    );
    expect(() => areaOfTriangle([0, null as never, 5])).toThrow(
      "Supplied inputs '[0,null,5]' is invalid: One or more sides is not a number"
    );
    expect(() => areaOfTriangle([0, 7, undefined as never])).toThrow(
      "Supplied inputs '[0,7,null]' is invalid: One or more sides is not a number"
    );
  });

  test("should throw an error for negative number input", () => {
    expect(() => areaOfTriangle([3, -1, 5])).toThrow(
      "Supplied inputs '[3,-1,5]' is invalid: One or more sides is less than 0"
    );
  });

  test("should throw an error for invalid triangle", () => {
    expect(() => areaOfTriangle([3, 4, 8])).toThrow(
      "Supplied inputs '[3,4,8]' is invalid: The sum of two sides should be greater than the third side"
    );
  });
});
