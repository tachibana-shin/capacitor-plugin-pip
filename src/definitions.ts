export interface PiPPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
