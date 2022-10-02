export class Response {
  id: number;
  ageRange: string;
  isStudent: boolean;
  incomeRange: string;

  constructor(ageRange: string, isStudent: boolean, incomeRange: string){
    this.ageRange = ageRange;
    this.isStudent = isStudent;
    this.incomeRange = incomeRange;
  }
}
