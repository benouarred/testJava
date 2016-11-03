import './main.css';

export const main = () => {
  fetch('api/todos')
    .then(res => res.json())
    .then(console.table)
    .catch(console.error)
  ;
}
