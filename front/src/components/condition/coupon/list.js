import {Datagrid, Filter, List, NumberInput, TextField} from 'react-admin';

const ConditionCouponFilter = (props) => (
    <Filter {...props}>
        <NumberInput label="Id" source="id"/>
    </Filter>
);

export const ConditionCouponList = (props) => (
    <List filters={<ConditionCouponFilter/>} {...props}>
        <Datagrid>
            <TextField source="id"/>
            <TextField label="Наименование" source="name"/>
        </Datagrid>
    </List>
)

export default ConditionCouponList