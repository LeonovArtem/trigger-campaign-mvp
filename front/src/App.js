import React from 'react';
import {Admin, Resource} from 'react-admin';
import CustomLayout from "./layout/CustomLayout";
import jsonServerProvider from 'ra-data-json-server';
import campaigns from './components/triggerCampaign/'
import conditionsCoupon from './components/condition/coupon'
import conditionsRefill from './components/condition/refill'
import conditionsUser from './components/condition/user'

function App() {
  return (
      <Admin
          dataProvider={jsonServerProvider(process.env.REACT_APP_DATA_PROVIDER)}
          title="Trigger campaign"
          layout={CustomLayout}
          disableTelemetry
      >
          <Resource name="trigger-campaign" {...campaigns} options={{ label: 'Кампании' }}/>
          <Resource name="conditions" options={{ "label": "Условия", "isMenuParent": true }} />
          <Resource name="condition-coupon" {...conditionsCoupon} options={{ label: 'На купон', "menuParent": "conditions" }}/>
          <Resource name="condition-refill" {...conditionsRefill} options={{ label: 'На депозит', "menuParent": "conditions" }}/>
          <Resource name="condition-user" {...conditionsUser} options={{ label: 'На регистрацию', "menuParent": "conditions" }}/>
          <Resource name="condition"/>
      </Admin>
  );
}

export default App;
