import type { PluginListenerHandle } from "@capacitor/core";

export interface PiPPlugin {
  enterPip(): Promise<void>;
  isPipSupported(): Promise<{ isSupported: boolean }>;

  addListener(
    eventName: 'pipModeChanged',
    listenerFunc: (opts: { isInPipMode: boolean }) => void,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  removeAllListeners(): Promise<void>;
}
