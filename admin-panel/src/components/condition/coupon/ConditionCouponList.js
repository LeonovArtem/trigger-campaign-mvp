import {
    CloneButton,
    Datagrid,
    EditButton,
    Filter,
    List,
    NumberInput,
    TextField,
    TextInput,
} from 'react-admin';
import ConditionCouponShow from './show/ShowForList';

const ConditionCouponFilter = props => (
    <Filter {...props}>
        <NumberInput label="Id" source="id" />
        <TextInput label="resources.condition.name" source="name" resettable />
    </Filter>
);

export const ConditionCouponList = props => (
    <List filters={<ConditionCouponFilter />} {...props}>
        <Datagrid expand={<ConditionCouponShow />}>
            <TextField source="id" />
            <TextField label="resources.condition.name" source="name" />
            <EditButton />
            <CloneButton />
        </Datagrid>
    </List>
);

export default ConditionCouponList;
