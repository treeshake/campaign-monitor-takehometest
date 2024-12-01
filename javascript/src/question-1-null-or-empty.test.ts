import { isNullOrEmpty } from './question-1-null-or-empty';

test('should return true for null', () => {
  expect(isNullOrEmpty(null)).toBe(true);
});

test('should return true for undefined', () => {
  expect(isNullOrEmpty(undefined)).toBe(true);
});

test('should return true for empty string', () => {
  expect(isNullOrEmpty("")).toBe(true);
});

test('should return false for non-empty string', () => {
  expect(isNullOrEmpty("hello")).toBe(false);
});

test('should return false for number', () => {
  expect(isNullOrEmpty(123)).toBe(false);
});

test('should return false for object', () => {
  expect(isNullOrEmpty({})).toBe(false);
});

test('should return false for array', () => {
  expect(isNullOrEmpty([])).toBe(false);
});

test('should return false for boolean', () => {
  expect(isNullOrEmpty(true)).toBe(false);
  expect(isNullOrEmpty(false)).toBe(false);
});