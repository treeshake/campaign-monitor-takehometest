/**
 * Question 1 - Is null or empty
 */
export function isNullOrEmpty(arg: unknown): boolean {
  // Including undefined for completeness
  if (arg === null || arg === undefined) {
    return true;
  }
  if (typeof arg === "string") {
    return arg === "";
  }
  // Only consider string, but could be extended to other types here
  // such as array, object, number
  return false;
}
