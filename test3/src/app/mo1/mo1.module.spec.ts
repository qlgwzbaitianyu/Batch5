import { Mo1Module } from './mo1.module';

describe('Mo1Module', () => {
  let mo1Module: Mo1Module;

  beforeEach(() => {
    mo1Module = new Mo1Module();
  });

  it('should create an instance', () => {
    expect(mo1Module).toBeTruthy();
  });
});
