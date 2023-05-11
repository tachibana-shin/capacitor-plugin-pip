import { WebPlugin } from '@capacitor/core';

import type { PiPPlugin } from './definitions';

export class PiPWeb extends WebPlugin implements PiPPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
