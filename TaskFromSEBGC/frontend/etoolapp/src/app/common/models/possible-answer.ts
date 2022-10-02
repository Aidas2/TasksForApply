export class PossibleAnwers {
  // NICE TO HAVE: store answers not here, but in data base
  public answersToAge = [
    {id: 1, title: 'YOUNG', minAge: 0, maxAge: 17, description: '0-17'},
    {id: 2, title: 'MIDDLE', minAge: 18, maxAge: 64, description: '18-64'},
    {id: 3, title: 'SENIOR', minAge: 65, maxAge: null, description: '65+'}
  ];

  public answersToIncome = [
    {id: 1, title: 'ZERO', minIncome: 0, maxIncome: 0, description: '0'},
    {id: 2, title: 'SMALL', minIncome: 1, maxIncome: 1200, description: '1-12000'},
    {id: 3, title: 'MEDIUM', minIncome: 1201, maxIncome: 4000, description: '12001-40000'},
    {id: 4, title: 'LARGE', minIncome: 4001, maxIncome: null, description: '40001+'}
  ];
}

// *ngFor iterates array, but not enum
export enum AgeRange {
  YOUNG = '0-17',
  MIDDLE = '18-64',
  SENIOR = '65+',
}

export enum IncomeRange {
  SMALL = '0',
  MEDIUM = '1-12000',
  BIG = '12001-40000',
  LARGE = '40001+',
}
