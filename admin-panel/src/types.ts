import { RaRecord, Identifier } from 'react-admin';

export type ThemeName = 'light' | 'dark';

export interface Campaign extends RaRecord {
    id: Identifier;
    isPublished: boolean;
    clientPlatforms: any;
}
