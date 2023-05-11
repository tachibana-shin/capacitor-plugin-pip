import { WebPlugin } from '@capacitor/core';

import type { PiPPlugin } from './definitions';

export class PiPWeb extends WebPlugin implements PiPPlugin {
  async enterPip(): Promise<void> {
    throw new Error('Picture-in-Picture mode not supported on this platform');
  }

  async isPipSupported(): Promise<{ isSupported: boolean }> {
    return { isSupported: false };
  }
}