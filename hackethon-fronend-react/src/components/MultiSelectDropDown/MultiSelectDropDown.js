import React from 'react';
import Select from 'react-select';

const MultiSelectDropdown = ({ options, value, onChange }) => {
  return (
    <Select
      options={options}
      value={value}
      onChange={onChange}
      isMulti
      closeMenuOnSelect={false}
    />
  );
};

export default MultiSelectDropdown;
