/**
 * Question 4 - Most common
 */
export function findMostCommon(numbers: number[]): number[] {
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
