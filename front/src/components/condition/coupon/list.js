import {Datagrid, Filter, List, TextField, TextInput} from 'react-admin';

const PostFilter = (props) => (
    <Filter {...props}>
        <TextInput label='Поиск' source='q' alwaysOn/>
    </Filter>
);

export const ConditionCouponList = (props) => (
    <List filters={<PostFilter/>} {...props}>
        <Datagrid>
            <TextField label="Наименование" source="name"/>
            <TextField label="Описание" source="description"/>
        </Datagrid>
    </List>
)

export default ConditionCouponList