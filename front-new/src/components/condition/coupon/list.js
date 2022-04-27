import {
    CloneButton,
    Datagrid,
    EditButton,
    Filter,
    List,
    NumberInput,
    TextField,
} from 'react-admin';
import ConditionCouponShow from './show';

const ConditionCouponFilter = props => (
    <Filter {...props}>
        <NumberInput label="Id" source="id" />
    </Filter>
);

export const ConditionCouponList = props => (
    <List filters={<ConditionCouponFilter />} {...props}>
        <Datagrid expand={<ConditionCouponShow />}>
            <TextField source="id" />
            <TextField label="Наименование" source="name" />
            <EditButton />
            <CloneButton />
        </Datagrid>
    </List>
);

export default ConditionCouponList;
