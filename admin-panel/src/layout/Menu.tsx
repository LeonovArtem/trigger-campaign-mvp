import * as React from 'react';
import { useState } from 'react';
import Box from '@mui/material/Box';
import ConditionCouponMenuIcon from '@mui/icons-material/LocalActivity';
import ConditionRefillMenuIcon from '@mui/icons-material/AttachMoney';
import ConditionUserMenuIcon from '@mui/icons-material/Person';
import TriggerCampaignMenuIcon from '@mui/icons-material/HomeWork';
import VisitorIcon from '@mui/icons-material/People';
import SubMenu from './SubMenu';
import {
    MenuItemLink,
    MenuProps,
    useSidebarState,
    useTranslate,
} from 'react-admin';

type MenuName = 'menuCatalog' | 'menuSales' | 'menuCustomers';

const Menu = ({ dense = false }: MenuProps) => {
    const [state, setState] = useState({
        menuCatalog: true,
        menuSales: true,
        menuCustomers: true,
    });
    const translate = useTranslate();
    const [open] = useSidebarState();

    const handleToggle = (menu: MenuName) => {
        setState(state => ({ ...state, [menu]: !state[menu] }));
    };

    return (
        <Box
            sx={{
                width: open ? 240 : 50,
                marginTop: 1,
                marginBottom: 1,
                transition: theme =>
                    theme.transitions.create('width', {
                        easing: theme.transitions.easing.sharp,
                        duration: theme.transitions.duration.leavingScreen,
                    }),
            }}
        >
            <MenuItemLink
                to="/campaign"
                state={{ _scrollToTop: true }}
                primaryText={translate(`resources.campaign.name`, {
                    smart_count: 2,
                })}
                leftIcon={<TriggerCampaignMenuIcon />}
                dense={dense}
            />
            <SubMenu
                handleToggle={() => handleToggle('menuCustomers')}
                isOpen={state.menuCustomers}
                name="pos.menu.conditions"
                icon={<VisitorIcon />}
                dense={dense}
            >
                <MenuItemLink
                    to="/condition-coupon"
                    state={{ _scrollToTop: true }}
                    primaryText={translate(`resources.conditionCoupon.name`, {
                        smart_count: 2,
                    })}
                    leftIcon={<ConditionCouponMenuIcon />}
                    dense={dense}
                />
                <MenuItemLink
                    to="/condition-refill"
                    state={{ _scrollToTop: true }}
                    primaryText={translate(`resources.conditionRefill.name`, {
                        smart_count: 2,
                    })}
                    leftIcon={<ConditionRefillMenuIcon />}
                    dense={dense}
                />
                <MenuItemLink
                    to="/condition-user"
                    state={{ _scrollToTop: true }}
                    primaryText={translate(`resources.conditionUser.name`, {
                        smart_count: 2,
                    })}
                    leftIcon={<ConditionUserMenuIcon />}
                    dense={dense}
                />
            </SubMenu>
        </Box>
    );
};

export default Menu;
