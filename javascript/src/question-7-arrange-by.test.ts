import { arrangeBy } from "./question-7-arrange-by";

interface User {
  id: number;
  name?: string;
  age?: number | null;
  isMale?: boolean;
}

const users: User[] = [
  { id: 1, name: "John", age: 30, isMale: true },
  { id: 2, name: "Jane", age: 25, isMale: false },
  { id: 3, name: "Mary", age: 30, isMale: false },
  { id: 4, name: "Joe", age: 38, isMale: true },
  { id: 5, name: "Mike", age: 38, isMale: true },
  { id: 6, name: "Mike", age: 40, isMale: true },
];

test("should arrange users using name (check string types)", () => {
  const arrangedByName = arrangeBy("name");
  expect(arrangedByName(users)).toEqual({
    John: [{ id: 1, name: "John", age: 30, isMale: true }],
    Jane: [{ id: 2, name: "Jane", age: 25, isMale: false }],
    Mary: [{ id: 3, name: "Mary", age: 30, isMale: false }],
    Joe: [{ id: 4, name: "Joe", age: 38, isMale: true }],
    Mike: [
      { id: 5, name: "Mike", age: 38, isMale: true },
      { id: 6, name: "Mike", age: 40, isMale: true },
    ],
  });
});

test("should arrange users using age (check number types)", () => {
  const arrangedByAge = arrangeBy("age");
  expect(arrangedByAge(users)).toEqual({
    "25": [{ id: 2, name: "Jane", age: 25, isMale: false }],
    "30": [
      { id: 1, name: "John", age: 30, isMale: true },
      { id: 3, name: "Mary", age: 30, isMale: false },
    ],
    "38": [
      { id: 4, name: "Joe", age: 38, isMale: true },
      { id: 5, name: "Mike", age: 38, isMale: true },
    ],
    "40": [{ id: 6, name: "Mike", age: 40, isMale: true }],
  });
});

test("should arrange using isMale - (check boolean types)", () => {
  const arrangedByIsMale = arrangeBy("isMale");
  expect(arrangedByIsMale(users)).toEqual({
    true: [
      { id: 1, name: "John", age: 30, isMale: true },
      { id: 4, name: "Joe", age: 38, isMale: true },
      { id: 5, name: "Mike", age: 38, isMale: true },
      { id: 6, name: "Mike", age: 40, isMale: true },
    ],
    false: [
      { id: 2, name: "Jane", age: 25, isMale: false },
      { id: 3, name: "Mary", age: 30, isMale: false },
    ],
  });
});

test("should return an empty object when key does not exist", () => {
  const arrangedByGender = arrangeBy("gender");
  expect(arrangedByGender(users)).toEqual({});
});

test("should exclude values which are null or not defined", () => {
  const arrangedByAge = arrangeBy("age");
  const users = [
    { id: 1, name: "John", age: 21 },
    { id: 1, name: "Mary" },
    { id: 1, name: "Mark", age: null },
  ];
  expect(arrangedByAge(users)).toEqual({
    "21": [{ id: 1, name: "John", age: 21 }],
  });
});

test("should exclude null or not defined objects as inputs", () => {
  const arrangedByAge = arrangeBy("name");
  const users = [
    { id: 1, name: "John", age: 21 },
    null as unknown as object,
    undefined as unknown as object
  ];
  expect(arrangedByAge(users)).toEqual({
    "John": [{ id: 1, name: "John", age: 21 }],
  });
});