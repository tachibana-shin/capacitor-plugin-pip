import { registerPlugin } from '@capacitor/core';

import type { PiPPlugin } from './definitions';

const PiP = registerPlugin<PiPPlugin>('PiP', {
  web: () => import('./web').then(m => new m.PiPWeb()),
});

export * from './definitions';
export { PiP };
