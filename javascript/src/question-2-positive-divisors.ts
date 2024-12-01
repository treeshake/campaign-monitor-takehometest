
/**
 * Question 2 - Positive divisors
 */
export function findPositiveDivisors(number: number): number[] {
  const positiveDivisors = [];
  for (let i = 1; i <= number; i++) {
    if (number % i === 0) {
      positiveDivisors.push(i);
    }
  }
  return positiveDivisors;
}
