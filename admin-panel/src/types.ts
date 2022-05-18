import { RaRecord, Identifier } from 'react-admin';

export interface Campaign extends RaRecord {
    id: Identifier;
    isPublished: boolean;
    clientPlatforms: any;
}
