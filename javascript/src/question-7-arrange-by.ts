/**
 * Question 7
 */
export function arrangeBy(key: string) {
  return (objects: object[]) => arrangeObjectsByKey(objects, key);
}

function arrangeObjectsByKey(objects: object[], key: string): Record<string, object[]> {
  const arrangedResult: Record<string, object[]> = {};
  for (const object of objects) {
    if (isNullOrUndefined(object)) {
      continue;
    }
    for (const [currentKey, value] of Object.entries(object)) {
      if (currentKey !== key) {
        continue;
      }
      if (isNullOrUndefined(value)) {
        continue;
      }
      const stringifiedValue = String(value);
      if (!arrangedResult[stringifiedValue]) {
        arrangedResult[stringifiedValue] = [];
      }
      arrangedResult[stringifiedValue].push(object);
    }
  }
  return arrangedResult;
}

function isNullOrUndefined(value: unknown): boolean {
  return value === null || value === undefined;
}
