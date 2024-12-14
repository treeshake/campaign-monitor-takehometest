/**
 * Question 3 - Area of triangle
 * Formula and reference: https://www.cuemath.com/measurement/area-of-triangle-with-3-sides/
 * Variables names kept the same as the above for easier understanding
 */

type TriangleInputs = [number, number, number];

export function areaOfTriangle(inputs: TriangleInputs): number {
  if (inputs.some(isNotANumber)) {
    throw new InvalidTriangleException(
      inputs,
      "One or more sides is not a number"
    );
  }
  if (inputs.some(isLessThanOrEqualToZero)) {
    throw new InvalidTriangleException(
      inputs,
      "One or more sides is less than 0"
    );
  }
  if (!areSidesValid(inputs)) {
    throw new InvalidTriangleException(
      inputs,
      "The sum of two sides should be greater than the third side"
    );
  }

  const [a, b, c] = inputs;
  const s = (a + b + c) / 2;
  return Math.sqrt(s * (s - a) * (s - b) * (s - c));
}

function isLessThanOrEqualToZero(value: number) {
  return value <= 0;
}

function isNotANumber(value: unknown): boolean {
  return typeof value !== "number" || isNaN(value);
}

/**
 * Reference: https://www.geeksforgeeks.org/check-whether-triangle-valid-not-sides-given/
 */
function areSidesValid(inputs: TriangleInputs): boolean {
  const [a, b, c] = inputs;
  return a + b > c && b + c > a && a + c > b;
}

class InvalidTriangleException extends Error {
  constructor(inputs: TriangleInputs, message: string) {
    super();
    this.name = "InvalidTriangleException";
    this.message = `Supplied inputs '${JSON.stringify(inputs)}' is invalid: ${message}`; // prettier-ignore
  }
}
