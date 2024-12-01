import { areaOfTriangle } from './question-3-area-triangle';

test('should calculate the area of a triangle', () => {
  expect(areaOfTriangle(3, 4, 5)).toBeCloseTo(6);
});

test('should throw an error', () => {
  expect(() => areaOfTriangle(NaN, 4, 5)).toThrow('Invalid input: One or more sides is not a number');
  expect(() => areaOfTriangle(3, -1, 5)).toThrow('Invalid input: One or more sides is less than 0');
});
