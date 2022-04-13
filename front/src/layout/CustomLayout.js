import TreeMenu from '@bb-tech/ra-treemenu';
import {Layout} from 'react-admin';
import AppBar from './AppBar';
import CustomMenu from './Menu';

const CustomLayout = (props) => {
    TreeMenu.defaultProps.dashboardlabel = 'My Dashboard';
    return <Layout {...props} menu={CustomMenu} appBar={AppBar} />
};

export default CustomLayout;