import logo from './logo.svg';
import './App.css';
import MainHeader from './common/MainHeader';
import MainFooter from './common/MainFooter';
import Cards from './cards/Cards';

function App() {
  return (

    <div>
      <MainHeader></MainHeader>
      <Cards></Cards>
      <MainFooter></MainFooter>
    </div>
  );
}

export default App;
