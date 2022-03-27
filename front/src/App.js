import { Admin, Resource } from 'react-admin';
import restProvider from 'ra-data-simple-rest'
import CustomLayout from "./layout/CustomLayout";
import campaigns from './components/triggerCampaign/'
import conditionsCoupon from './components/condition/coupon'
import conditionsRefill from './components/condition/refill'
import conditionsUser from './components/condition/user'

function App() {
  return (
      <Admin
          dataProvider={restProvider('http://localhost:8082/api/v1')}
          title="Trigger campaign"
          layout={CustomLayout}
          disableTelemetry
      >
          <Resource name="trigger-campaign" {...campaigns} options={{ label: 'Кампании' }}/>
          <Resource name="conditions" options={{ "label": "Условия", "isMenuParent": true }} />
          <Resource name="condition-coupon" {...conditionsCoupon} options={{ label: 'На купон', "menuParent": "conditions" }}/>
          <Resource name="condition-refill" {...conditionsRefill} options={{ label: 'На депозит', "menuParent": "conditions" }}/>
          <Resource name="condition-user" {...conditionsUser} options={{ label: 'На регистрацию', "menuParent": "conditions" }}/>
      </Admin>
  );
}

export default App;
