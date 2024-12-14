/**
 * Question 2 - Positive divisors
 */
export function findPositiveDivisors(number: unknown): number[] {
  if (typeof number !== "number" || number < 0 || isNaN(number)) {
    throw new NonPositiveNumberException(number);
  }
  const positiveDivisors = [];
  // Optimisation: Factors are paired, iterate to the sqrt of number, then add both i and number/i
  // then, https://stackoverflow.com/questions/26753839/efficiently-getting-all-divisors-of-a-given-number
  const sqrtNumber = Math.sqrt(number);
  for (let i = 1; i <= sqrtNumber; i++) {
    if (number % i === 0) {
      positiveDivisors.push(i, number / i);
    }
  }
  return positiveDivisors.sort((a, b) => a - b);
}

class NonPositiveNumberException extends Error {
  constructor(value: unknown) {
    super();
    this.name = "NonPositiveNumberException";
    this.message = `Invalid input: Expected positive number, but got '${value}'`;
  }
}
