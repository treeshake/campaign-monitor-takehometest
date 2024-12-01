/**
 * Question 3 - Area of triangle
 * Formula and reference: https://www.cuemath.com/measurement/area-of-triangle-with-3-sides/
 * Variables names kept the same as the above for easier understanding
 */
export function areaOfTriangle(a: number, b: number, c: number): number {
  if ([a, b, c].some(isNaN)) {
    throw new InvalidTriangleException(
      "Invalid input: One or more sides is not a number"
    );
  }

  if ([a, b, c].some(isLessThanOrEqualToZero)) {
    throw new InvalidTriangleException(
      "Invalid input: One or more sides is less than 0"
    );
  }

  const s = (a + b + c) / 2;
  return Math.sqrt(s * (s - a) * (s - b) * (s - c));
}

function isLessThanOrEqualToZero(value: number) {
  return value <= 0;
}

class InvalidTriangleException extends Error {
  constructor(message: string) {
    super(message);
    this.name = "InvalidTriangleException";
  }
}
