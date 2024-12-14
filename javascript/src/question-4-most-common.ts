/**
 * Question 4 - Most common
 */
export function findMostCommon(input: unknown): number[] {
  // Validate inputs: Check if the input is an array, if it's empty, and if it contains only numbers.

  if (!Array.isArray(input)) {
    throw new InvalidInputException(input, "Expected an array");
  }

  if (input.length === 0) {
    return [];
  }

  if (input.some(isNotANumber)) {
    throw new InvalidInputException(
      input,
      "One or more values is not a number"
    );
  }

  // Coerce the input to a number array since we've already validated the input.
  const numbers = input as number[];

  // An inner function that accepts a "count" value and runs a filter on the input numbers array.
  const countOccurrences = (count: number) =>
    numbers.filter((number) => number === count).length;

  // Finds the max. occurrence of each number in the supplied input array by running a reduce function
  // The reduce function will find the max. occurrence value.
  const maxOccurrence = numbers.reduce((prev: number, curr: number) => {
    const found = countOccurrences(curr);
    return found > prev ? found : prev;
  }, 0);

  // Return only the numbers that have the max. occurrence value.
  const uniqueResults = new Set(
    numbers.filter((number) => countOccurrences(number) === maxOccurrence)
  );

  return Array.from(uniqueResults);
}

function isNotANumber(value: unknown): value is number {
  return typeof value !== "number" || isNaN(value);
}

class InvalidInputException extends Error {
  constructor(input: unknown, message: string) {
    super(message);
    this.name = "InvalidInputException";
    this.message = `Supplied input '${JSON.stringify(
      input
    )}' is invalid: ${message}`;
  }
}
